import { configureStore } from '@reduxjs/toolkit';
import { restaurantApi } from 'store/restaurantApi';

export * from 'store/restaurantApi';

export const store = configureStore({
  reducer: {
    [restaurantApi.reducerPath]: restaurantApi.reducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(restaurantApi.middleware),
});
