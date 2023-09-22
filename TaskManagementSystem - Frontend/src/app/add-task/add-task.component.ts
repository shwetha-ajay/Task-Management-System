import { Component } from '@angular/core';
import { TmsServiceService } from '../services/tms-service.service';
import { Router } from 'express';
import { Task } from '../class/task';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent {
  // tasks:any
  // newTask: Task = new Task();
  // title!:string;
  // status!:string;
  // priority!:number;
  // taskID!:number;
  // description!:string;
  // dueDate!:Date;
  // userID!:number;
  

  // constructor(private loginService: LoginServiceService,private router: Router) { }

  // addTask(): void {
  //   console.log(this.userID);
  //   this.newTask.taskID=this.taskID
  //   this.newTask.title=this.title
  //   this.newTask.status=this.status
  //   this.newTask.priority=this.priority
  //   this.newTask.description=this.description
  //   this.newTask.dueDate=this.dueDate
  //   this.newTask.userID = { userID: this.userID }
    
  //   console.log(this.newTask);
  //   this.loginService.addTask(this.newTask).subscribe((task: Task) => {
  //     this.tasks.push(task);
  //     console.log(task);
  //     this.newTask = new Task();
  //     this.getTasks();
  //   });
  // }

  // getTasks(): void {
  //   this.loginService.getTasks().subscribe((res) => {
  //     this.tasks = res;
  //     console.log(this.tasks);
  //   })
  // }



}
