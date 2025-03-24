'use client';
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from '@/components/ui/table';
import { fetchTransactionsFromServer } from '../../core/apiFunctions';
import { useEffect, useState } from 'react';

// Define the structure of a transaction object
interface Transaction {
  amount: number;
  type: boolean;
  balanceAfter: number;
  date: string;
}

const TableTransactions = () => {
  // State to hold the list of transactions
  const [transactions, setTransactions] = useState<Transaction[]>([
    { amount: 0, type: false, balanceAfter: 0, date: '' },
  ]);
  // Function to fetch transactions from the server and update state
  const fetchTransactions = async () => {
    const transactions = await fetchTransactionsFromServer();
    setTransactions(transactions);
  };
  // Fetch transactions when the component mounts
  useEffect(() => {
    fetchTransactions();
  }, []);
  // Helper function to return a human-readable transaction type
  const getTransactionType = (type: boolean) => {
    return type ? 'Deposit' : 'Withdrawal';
  };
  // Render the table structure with transaction data
  return (
    <Table>
      <TableCaption>A list of your recent invoices.</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead className="w-[100px]">Type</TableHead>
          <TableHead>Dato</TableHead>
          <TableHead>Beløp</TableHead>
          <TableHead className="text-right">Saldo Etter</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {transactions.map((transaction, index) => (
          <TableRow key={index}>
            <TableCell className="font-medium">
              {getTransactionType(transaction.type)}
            </TableCell>
            <TableCell>{transaction.date}</TableCell>
            <TableCell>{transaction.amount}kr</TableCell>
            <TableCell className="text-right">
              {transaction.balanceAfter}kr
            </TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
};

export default TableTransactions;
