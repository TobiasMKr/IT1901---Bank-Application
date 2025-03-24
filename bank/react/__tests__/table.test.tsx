import { render, screen, waitFor } from '@testing-library/react';
import TableTransactions from '@/components/table/table';
import { fetchTransactionsFromServer } from '@/core/APIfunctions';
import '@testing-library/jest-dom';

// Mock fetchTransactionsFromServer function
jest.mock('@/core/APIfunctions', () => ({
  fetchTransactionsFromServer: jest.fn(),
}));

describe('TableTransactions', () => {
  // Test data for mock response
  const mockTransactions = [
    { amount: 100, type: true, balanceAfter: 1000, date: '2023-11-01' },
    { amount: 50, type: false, balanceAfter: 950, date: '2023-11-02' },
  ];

  beforeEach(() => {
    // Set up mock implementation to return mock transactions
    (fetchTransactionsFromServer as jest.Mock).mockResolvedValue(mockTransactions);
  });

  it('fetches and displays transactions on load', async () => {
    render(<TableTransactions />);

    // Check if the component renders table headers correctly
    expect(screen.getByText('Type')).toBeInTheDocument();
    expect(screen.getByText('Dato')).toBeInTheDocument();
    expect(screen.getByText('Beløp')).toBeInTheDocument();
    expect(screen.getByText('Saldo Etter')).toBeInTheDocument();

    // Wait for mock transactions to load and display
    await waitFor(() => {
      expect(screen.getByText('Deposit')).toBeInTheDocument();
      expect(screen.getByText('Withdrawal')).toBeInTheDocument();
      expect(screen.getByText('100kr')).toBeInTheDocument();
      expect(screen.getByText('50kr')).toBeInTheDocument();
      expect(screen.getByText('1000kr')).toBeInTheDocument();
      expect(screen.getByText('950kr')).toBeInTheDocument();
      expect(screen.getByText('2023-11-01')).toBeInTheDocument();
      expect(screen.getByText('2023-11-02')).toBeInTheDocument();
    });
  });

  it('displays correct transaction type based on the boolean value', async () => {
    render(<TableTransactions />);

    // Wait for transactions to load and check displayed types
    await waitFor(() => {
      expect(screen.getByText('Deposit')).toBeInTheDocument();
      expect(screen.getByText('Withdrawal')).toBeInTheDocument();
    });
  });
});
