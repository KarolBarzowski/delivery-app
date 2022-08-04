import { setupWorker } from 'msw';
import { handlers } from 'mocks/handlers';
import { db } from 'mocks/db';

export const worker = setupWorker(...handlers);

db.people.create();
