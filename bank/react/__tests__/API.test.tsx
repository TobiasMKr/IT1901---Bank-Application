import {
  fetchBalanceFromServer,
  fetchTransactionsFromServer,
  postDepositToServer,
  postWithdrawalToServer,
} from '@/core/apiFunctions';
import axios from 'axios';

// Mock the axios module
jest.mock('axios');

// Define axios.get and axios.post as Jest mock functions
const mockedAxios = axios as jest.Mocked<typeof axios>;

describe('API Functions', () => {
  afterEach(() => {
    jest.clearAllMocks(); // Clear mocks after each test
  });

  it('fetches balance from server', async () => {
    // Mock response for axios.get
    const mockResponse = { data: 100 };
    mockedAxios.get.mockResolvedValue(mockResponse);

    const balance = await fetchBalanceFromServer();

    expect(axios.get).toHaveBeenCalledWith(
      'http://localhost:8080/bank/balance'
    );
    expect(balance).toEqual(mockResponse.data);
  });

  it('fetches transactions from server', async () => {
    // Mock response for axios.get
    const mockResponse = { data: [{ id: 1, amount: 50 }] };
    mockedAxios.get.mockResolvedValue(mockResponse);

    const transactions = await fetchTransactionsFromServer();

    expect(axios.get).toHaveBeenCalledWith(
      'http://localhost:8080/bank/transactions'
    );
    expect(transactions).toEqual(mockResponse.data);
  });

  it('posts a withdrawal to the server', async () => {
    // Mock response for axios.post
    mockedAxios.post.mockResolvedValue({ status: 200 });

    const amount = '50.00';
    await postWithdrawalToServer(amount);

    expect(axios.post).toHaveBeenCalledWith(
      'http://localhost:8080/bank/withdraw',
      new URLSearchParams({ amount: '50.00' })
    );
  });

  it('posts a deposit to the server', async () => {
    // Mock response for axios.post
    mockedAxios.post.mockResolvedValue({ status: 200 });

    const amount = '100.00';
    await postDepositToServer(amount);

    expect(axios.post).toHaveBeenCalledWith(
      'http://localhost:8080/bank/deposit',
      new URLSearchParams({ amount: '100.00' })
    );
  });
});
