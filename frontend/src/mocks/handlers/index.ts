import { rest } from 'msw';
import { test } from 'mocks/data/test';

export const handlers = [
  rest.get('/test', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.json({
        test,
      })
    );
  }),
];
