import type { Metadata } from 'next';

import './globals.css';

export const metadata: Metadata = {
  title: 'Test',
  description: 'Test',
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html className="dark" lang="en">
      <body>
        <h1 className="scroll-m-20 text-7xl text-primary font-extrabold tracking-tight lg:text-5xl text-center mt-8">
          BANK
        </h1>
        {children}
      </body>
    </html>
  );
}
