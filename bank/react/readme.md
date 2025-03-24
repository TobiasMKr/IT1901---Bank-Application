# _React module_

This is a [Next.js](https://nextjs.org) project bootstrapped with [`create-next-app`](https://nextjs.org/docs/app/api-reference/cli/create-next-app). [Shadcn](https://ui.shadcn.com/?ref=shadcn.com) has been used as the component library, with [Tailwind](https://tailwindcss.com/) for styling. The project is using [Jest](https://jestjs.io/docs/testing-frameworks) for testing, and [ESlint](https://eslint.org/) and [Prettier](https://prettier.io/) for code quality.

## _Technologies used_
- [**_Node.js_ 20.18.0**](https://nodejs.org/en) (Important!)
- [**_Npm 10.8.2_**](https://www.npmjs.com/)
- [**_ESlint_ 8**](https://eslint.org/)
- [**_Axios_ 1.7.7**](https://axios-http.com/docs/intro)
- [**_Jest_ 29.7.0**](https://jestjs.io/docs/testing-frameworks)
- [**_Prettier_ 3.3.3**](https://prettier.io/)
- [**_Tailwind_ 3.4.1**](https://tailwindcss.com/)
- [**_Next.js_ 14.2.15**](https://nextjs.org/)




## _Pages_
The app consists of two pages; the homepage and the transactionspage. The homepage shows you the balance, as well as giving you the options to deposit and withdraw money. With the press of one button, you can access the transactionspage where you can see you transactionhistory. 

## _Testing_
To test the frontend in react, we utilize a framework calles Jest. Jest is a JavaScript testing framework commonly used in React applications to write and run tests. It helps ensure that our code works as expected by automating tests that verify different parts of our application. It also creates a report that shows the test coverage. 


## _Avalible scripts_

First, to install the dependencies:
```bash
npm run install
```
This will install all the dependencies you need to run the app.

To run the development server:

```bash
npm run dev
```
This runs the app in development mode
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

To run the tests:
```bash
npm run test
```
This will run the tests with jest and show a coverage report in the termial. To view the coverage report in the browser, go to [Report](/bank/react/coverage/lcov-report/index.html) and open in it the browser.

To check for code quality and format:
```bash
npm run lint
"&&"
npm run format
```
The first one will check the code quality of the codebase using ESlint. The second one will use prettier to format the code to our liking. These two combined will secure good code quality.

To build the app for production:
```bash
npm run build
```
This correctly bundles React in production mode and optimizes the build for the best performance. The app is now ready to deploy.

You can now launch the app in production mode with:
```bash
npm start
```
The app is now in production mode and you can accsess it on the same adress as earlier: [http://localhost:3000](http://localhost:3000).

## _Learn More_

To learn more about Next.js, take a look at the following resources:

- [Next.js Documentation](https://nextjs.org/docs) - learn about Next.js features and API.
- [Learn Next.js](https://nextjs.org/learn) - an interactive Next.js tutorial.


