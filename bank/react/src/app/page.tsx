'use client';
import { Button, buttonVariants } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { cn } from '@/lib/utils';
import Link from 'next/link';
import { useEffect, useRef, useState } from 'react';
import { useInView } from 'framer-motion';
import {
  fetchBalanceFromServer,
  postDepositToServer,
  postWithdrawalToServer,
} from '@/core/apiFunctions';

export default function Home() {
  const [balance, setBalance] = useState(0);
  const [submitAmount, setSubmitAmount] = useState('');
  const [withdrawAmount, setWithdrawAmount] = useState('');
  const [error, setError] = useState('');
  const ref = useRef(null);
  const isInView = useInView(ref);
  //Fetch balance function to fetch the balance from the bankaccount
  const fetchBalance = async () => {
    try {
      const balance = await fetchBalanceFromServer();
      setBalance(balance);
    } catch (error) {
      console.error('Error fetching balance:', error);
      setError('Failed to fetch balance. Please try again later.');
    }
  };
  //Withdraw function to withdraw the amount from the bankaccount
  const withdraw = async () => {
    try {
      await postWithdrawalToServer(withdrawAmount);
      fetchBalance();
      setWithdrawAmount('');
    } catch (error) {
      console.error('Error processing withdrawal:', error);
      setError('Failed to process withdrawal. Please try again later.');
    }
  };
  //Deposit function to deposit the amount to the bankaccount
  const deposit = async () => {
    try {
      await postDepositToServer(submitAmount);
      fetchBalance();
      setSubmitAmount('');
    } catch (error) {
      console.error('Error processing deposit:', error);
      setError('Failed to process deposit. Please try again later.');
    }
  };

  useEffect(() => {
    fetchBalance();
  }, []);

  return (
    <div
      className="grid grid-rows-[20px_1fr_20px] items-center justify-items-center p-8 gap-20 sm:p-10"
      style={{
        backgroundColor: 'var(--background)',
        color: 'var(--foreground)',
      }}
    >
      <div className="flex justify-start w-full">
        <Link //Link to the transactions page in form of a button
          className={cn(
            buttonVariants({ variant: 'default' }),
            'flex items-center justify-center gap-x-2'
          )}
          href="/Transactions"
        >
          <span>Transactions</span>
        </Link>
      </div>

      <main className="flex flex-col items-center gap-8 row-start-2">
        <h1
          ref={ref}
          className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl"
        >
          Your Balance
        </h1>

        {error && <p className="text-red-500 text-center">{error}</p>}

        <p
          style={{
            transition: 'all 2s ease-in-out',
            opacity: isInView ? 1 : 0,
            transform: isInView ? 'translateY(0)' : 'translateY(100)',
          }}
          className="text-2xl"
        >
          {' '}
          {/* Display the balance */}
          {balance},-
        </p>
        {/* Deposit and Withdraw input fields with buttons to send */}
        <div className="flex flex-row gap-20">
          {' '}
          <div className="flex flex-col">
            <Input
              type="number"
              placeholder="Deposit"
              value={submitAmount}
              onChange={(e) => setSubmitAmount(e.target.value)}
            />
            <Button
              className="mt-4 w-1/2 mx-auto"
              onClick={deposit}
              disabled={!submitAmount}
            >
              Deposit
            </Button>
          </div>
          <div className="flex flex-col">
            <Input
              type="number"
              placeholder="Withdraw"
              value={withdrawAmount}
              onChange={(e) => setWithdrawAmount(e.target.value)}
            />
            <Button
              className="mt-4 w-1/2 mx-auto"
              onClick={withdraw}
              disabled={!withdrawAmount}
            >
              Withdraw
            </Button>
          </div>
        </div>
      </main>
    </div>
  );
}
