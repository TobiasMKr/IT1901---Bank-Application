import { render } from '@testing-library/react';
import Page from '../src/app/(pages)/Transactions/page'; 
import TableTransactions from '@/components/table/table';
import '@testing-library/jest-dom';

// Mock the TableTransactions component
jest.mock('@/components/table/table', () => () => (
  <div data-testid="table-transactions">Table Transactions Mock</div>
));

describe('Page Component', () => {
  it('renders correctly', () => {
    const { getByText, getByTestId } = render(<Page />);

    // Check if the heading is present
    expect(getByText('Transactions')).toBeInTheDocument();

    // Check if the link to the home page is present
    expect(getByText('Home')).toBeInTheDocument();

    // Check if the TableTransactions component is rendered
    expect(getByTestId('table-transactions')).toBeInTheDocument();
  });

  it('contains a link to the home page', () => {
    const { getByRole } = render(<Page />);
    const link = getByRole('link', { name: 'Home' });

    expect(link).toHaveAttribute('href', '/'); // Ensure the link points to the home route
  });
});
