import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import { Restaurant } from 'types/Restaurant.interface';

export const restaurantApi = createApi({
  baseQuery: fetchBaseQuery({
    baseUrl: 'http://localhost:8080',
  }),
  endpoints: (builder) => ({
    getRestaurantsByCity: builder.query<Restaurant[], string>({
      query: (city) => `/getRestaurantsByCity/${city}`,
    }),
    getRestaurantById: builder.query<Restaurant, string>({
      query: (id) => `/getRestaurantById/${id}`,
    }),
  }),
});
