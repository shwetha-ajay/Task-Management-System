import { Component, OnInit } from '@angular/core';
import { TmsServiceService } from '../services/tms-service.service';
import { Login } from '../models/login';
import { HttpClient } from '@angular/common/http';
import { Task } from '../class/task';
import { compileNgModule } from '@angular/compiler';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { Taskscores } from '../class/taskscores';
import { FormControl, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

  export class AdminComponent implements OnInit {
    // tasks: Task[] = [];
    tasks:any
    newTask: Task = new Task();
    title!:string;
    status: string = '';
    priority!:number;
    taskID!:number;
    description!:string;
    dueDate!:Date;
    // userID!:number;
    userID: string='' ;
    workID!:number;
    scores: number[] = [];
    taskScores: Taskscores[] = [];
    response:any
    search!:string
    showTable=true
    searchedTasks:any
    userIds: number[] = []; 
    
    taskForm=new FormGroup({
      title: new FormControl('',[ Validators.required]),
      description: new FormControl('',[ Validators.required]),
      status: new FormControl('',[ Validators.required]),
      priority: new FormControl('',[ Validators.required, Validators.max(5)]),
      duedate: new FormControl('',[ Validators.required]),
    })
    
    

    
  constructor(private loginService: TmsServiceService,private router: Router) { }
  
  ngOnInit(): void {
      this.getTasks();
      this.fetchUserIds()
    }

  onSearch() {
      // console.log("Hello");
      if(this.search==null){
        this.showTable=true
      }
      const searchValue = this.search.toString().split(' '); 

      const filteredTasks = this.tasks.filter((task: { taskID: number }) =>
      searchValue.some(value => task.taskID.toString().includes(value))
      );
      // ReversedFilterdTasks
      this.searchedTasks = filteredTasks
      console.log(this.searchedTasks);
      this.showTable=false
    }

  onDelete(taskID: number) { this.loginService.deleteTask(taskID).subscribe((res) =>
    { 
    console.log("delete");
    this.getTasks();
    });        
    }

  getTasks(): void {
      this.loginService.getTasks().subscribe((res) => {
        this.tasks = res;
        console.log(this.tasks);
      })
    }
// list userids
  fetchUserIds(): void {
      this.loginService.getUserIds().subscribe(
        (userIds: number[]) => {
          console.log(userIds);
          this.userIds = userIds;
        },
        (error: any) => {
          console.log('Error fetching user IDs:', error);
        }
      );
    }
  
  addTask(): void {
      console.log(this.userID);
      this.newTask.taskID=this.taskID
      this.newTask.title=this.title
      this.newTask.status=this.status
      this.newTask.priority=this.priority
      this.newTask.description=this.description
      this.newTask.dueDate=this.dueDate
      console.log(this.priority);
      // this.newTask.userID = { userID: this.userID }
      this.newTask.userID = { userID: parseInt(this.userID) };
      console.log(this.newTask);
      this.loginService.addTask(this.newTask).subscribe((task: Task) => {
        this.tasks.push(task);
        console.log(task);
        this.newTask = new Task();
        this.getTasks();
      });
    }

  tasksPriority(){
      this.loginService.sort(777).subscribe((res)=>{
        console.log(res);
        this.response=res
        this.response.sort((a: { score: number; }, b: { score: number; }) => b.score - a.score);
        console.log(this.response);
        let i=0
        while(i<this.tasks.length){
          this.tasks[i].taskID=this.response[i].taskID
          this.tasks[i].title=this.response[i].title
          this.tasks[i].status=this.response[i].status
          this.tasks[i].priority=this.response[i].priority
          this.tasks[i].dueDate=this.response[i].dueDate
          this.tasks[i].description=this.response[i].description
          this.tasks[i].userID.userID=this.response[i].userID.userID
          i++
        }
      })    
  }
  

  updateStatus(taskId: number,status:string): void {
      this.loginService.updateStatus(taskId,status).subscribe(
        () => {
          console.log('Task status updated successfully.');
        },
        (error: any) => {
          console.error('Error updating task status:', error);
        }
      );
  }


  filter(){
      this.tasks.sort((a: { priority: number; }, b: { priority: number; }) => a.priority - b.priority);
      console.log(this.tasks);
  }


  }
