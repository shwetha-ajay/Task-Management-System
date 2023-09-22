import { Taskscores } from './taskscores';

// describe('Taskscores', () => {
//   it('should create an instance', () => {
//     expect(new Taskscores()).toBeTruthy();
//   });
// });
describe('Taskscores', () => {
  it('should create an instance', () => {
    const taskID = 123;
    const title = 'Sample Title';
    const status = 'Completed';
    const priority = 1;
    const dueDate = new Date();
    const description = 'Sample Description';
    const workID = 456;
    const userID = { userID: 789 };
    const score = 10;

    const taskscore = new Taskscores(
      taskID,
      title,
      status,
      priority,
      dueDate,
      description,
      workID,
      userID,
      score
    );

    expect(taskscore).toBeTruthy();
  });
});
