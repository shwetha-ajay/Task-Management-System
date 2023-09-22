export class Taskscores {
    taskID: any;
    title: any;
    status: any;
    priority: any;
    dueDate: any;
    description: any;
    workID: any;
    userID: { userID: any };
    score: number;
  
    constructor(
      taskID: any,
      title: any,
      status: any,
      priority: any,
      dueDate: any,
      description: any,
      workID: any,
      userID: { userID: any },
      score: number
    ) {
      this.taskID = taskID;
      this.title = title;
      this.status = status;
      this.priority = priority;
      this.dueDate = dueDate;
      this.description = description;
      this.workID = workID;
      this.userID = userID;
      this.score = score;
    }
  }
  