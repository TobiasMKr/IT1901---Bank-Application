import axios from 'axios';

let apiURL = `http://localhost:8080`;
if (typeof window !== 'undefined' && window.location.hostname !== 'localhost') {
  const hostname = window.location.hostname;
  apiURL = `https://${hostname.replace(`3000`, `8080`)}`;
}



export const fetchBalanceFromServer = async () => {
  const axe = axios.get(`${apiURL}/bank/balance`);
  return axe.then((response) => response.data);
};

export const fetchTransactionsFromServer = async () => {
  const axe = axios.get(`${apiURL}/bank/transactions`);
  return axe.then((response) => response.data);
};

const formatAmount = (amount) => {
  const formattedAmount = parseFloat(amount).toFixed(2);
  const params = new URLSearchParams();
  params.append('amount', formattedAmount);
  return params;
};

export const postWithdrawalToServer = (amount) => {
  return axios.post(`${apiURL}/bank/withdraw`, formatAmount(amount));
};

export const postDepositToServer = (amount) => {
  return axios.post(`${apiURL}/bank/deposit`, formatAmount(amount));
};
