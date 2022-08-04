import { rest } from 'msw';
import { test } from 'mocks/data/test';
import { db } from 'mocks/db';

export const handlers = [
  rest.get('/people', (req, res, ctx) => {
    const people = db.people.getAll();
    return res(ctx.status(200), ctx.json(people));
  }),
  rest.get('/test', (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.json({
        test,
      })
    );
  }),
];
