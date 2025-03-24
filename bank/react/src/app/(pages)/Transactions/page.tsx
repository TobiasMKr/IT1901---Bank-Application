import { buttonVariants } from '@/components/ui/button';
import { cn } from '@/lib/utils';
import Link from 'next/link';
import TableTransactions from '@/components/table/table';

const page = () => {
  return (
    <div className="grid grid-rows-[20px_1fr_20px] items-center justify-items-center p-8 gap-20 sm:p-16">
      <div className="flex justify-start w-full">
        <Link //Link to the home page in form of a button
          className={cn(
            buttonVariants({ variant: 'default' }),
            'flex items-center justify-center gap-x-2'
          )}
          href="/"
        >
          <span>Home</span>
        </Link>
      </div>
      <main className="flex flex-col items-center gap-8 row-start-2">
        <h1 className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl">
          Transactions
        </h1>
        {/* Table component showing all the transactions */}
        <TableTransactions /> 
      </main>
    </div>
  );
};

export default page;
