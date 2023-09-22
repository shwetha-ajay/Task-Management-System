import { Component, OnInit } from '@angular/core';
import { TmsServiceService } from '../services/tms-service.service';

import { Task } from '../class/task';
import { User } from '../class/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user:any
  email!:String;
  users:any
  userID!:any
  tasks!:any
  admin=false
  spinnerService: any;


constructor(private service:TmsServiceService,private router:Router){}

ngOnInit(): void {
    if(this.service.getRole()=="Admin"){
       this.admin=true
    }

    this.email=this.service.getEmail()
    console.log(this.email)
    
    this.service.getuserId(this.email).subscribe((res)=>{
      this.userID=res
      // console.log(res);
      this.service.userTasks(this.userID).subscribe((res)=>{
      this.users=res
      console.log(res);
    })
    })   
}
 
logout(){
  // this.spinnerService.show(); // Show the spinner
  // setTimeout(() => {
  //   this.spinnerService.hide(); // Hide the spinner
  //   localStorage.clear();
  //  this.router.navigate(["/login"]) // Redirect to the home page
  // }, 2000); // Replace with your actual logout logic

   localStorage.clear();
   this.router.navigate(["/login"])
}

updateStatus(taskId: number,status:string): void {
    this.service.updateStatus(taskId,status).subscribe(
      () => {
        console.log('Task status updated successfully.');
      },
      (error: any) => {
        console.error('Error updating task status:', error);
      }
    );
  }
}




