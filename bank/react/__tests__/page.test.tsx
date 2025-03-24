import '@testing-library/jest-dom';
import {
  render,
  screen,
  fireEvent,
  waitFor,
  act,
} from '@testing-library/react';
import Home from '../src/app/page';
import {
  fetchBalanceFromServer,
  postDepositToServer,
  postWithdrawalToServer,
} from '@/core/APIfunctions';

// Mock the API functions to avoid actual server calls during tests
jest.mock('../src/core/APIfunctions', () => ({
  fetchBalanceFromServer: jest.fn(),
  postDepositToServer: jest.fn(),
  postWithdrawalToServer: jest.fn(),
}));

describe('Home', () => {
  beforeEach(() => {
    // Set initial mocked return values for each test
    (fetchBalanceFromServer as jest.Mock).mockResolvedValue(100);
    (postDepositToServer as jest.Mock).mockResolvedValue(undefined);
    (postWithdrawalToServer as jest.Mock).mockResolvedValue(undefined);
  });

  it('renders the heading', async () => {
    await act(async () => {
      // Render the Home component
      render(<Home />);
    });
    // Check if the heading is rendered correctly
    const heading = screen.getByRole('heading', {
      level: 1,
      name: /Your Balance/i,
    });
    expect(heading).toBeInTheDocument();
  });

  it('fetches and displays the balance on load', async () => {
    await act(async () => {
      render(<Home />);
    });
    // Check if the balance is fetched and displayed correctly
    const balanceDisplay = await waitFor(() => screen.getByText('100,-'));
    expect(balanceDisplay).toBeInTheDocument();
  });

  it('allows the user to deposit an amount', async () => {
    await act(async () => {
      render(<Home />);
    });
    // Select the deposit input field and the deposit button
    const depositInput = screen.getByPlaceholderText('Deposit');
    const depositButton = screen.getByRole('button', { name: /Deposit/i });

    // Simulate entering a deposit amount of 50 and clicking the deposit button
    await act(async () => {
      fireEvent.change(depositInput, { target: { value: '50' } });
      fireEvent.click(depositButton);
    });
    // Verify that the deposit API was called with the amount "50"
    expect(postDepositToServer).toHaveBeenCalledWith('50');
    // Wait for the balance API to be called again to refresh the balance display
    await waitFor(() =>
      expect(fetchBalanceFromServer).toHaveBeenCalledTimes(4)
    );
  });

  it('allows the user to withdraw an amount', async () => {
    await act(async () => {
      render(<Home />);
    });
    // Select the withdraw input field and the withdraw button
    const withdrawInput = screen.getByPlaceholderText('Withdraw');
    const withdrawButton = screen.getByRole('button', { name: /Withdraw/i });

    // Simulate entering a withdrawal amount of 30 and clicking the withdraw button
    await act(async () => {
      fireEvent.change(withdrawInput, { target: { value: '30' } });
      fireEvent.click(withdrawButton);
    });
    // Verify that the withdraw API was called with the amount "30"
    expect(postWithdrawalToServer).toHaveBeenCalledWith('30');
    // Wait for the balance API to be called again to refresh the balance display
    await waitFor(() =>
      expect(fetchBalanceFromServer).toHaveBeenCalledTimes(6)
    );
  });
});
