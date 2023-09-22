import { Component, OnInit } from '@angular/core';
import { Login } from '../models/login';
import { TmsServiceService } from '../services/tms-service.service';
import { User } from '../class/user';
import { NgxPaginationModule } from 'ngx-pagination/public-api';
import { FormControl, FormGroup, MinLengthValidator, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  
  // users: User[] = [];
  users:any
  newUser: User = new User();
  userID!:number;
  name!:string;
  email!:string;
  password!:string;
  userRole!:string;
  
  page:number=1
  count:number=0
  tableSize:number=5
  userForm=new FormGroup({
    userRole: new FormControl('',[ Validators.required]),
    name: new FormControl('', Validators.required),
    email:new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required,Validators.minLength(6)])

  })

  constructor(private loginService: TmsServiceService ,private router:Router) { }
   

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
      this.loginService.getUsers().subscribe((res) => {
      this.users = res;
      console.log(this.users);
    });
  }


  onTableDataChange(event:any){
  this.page=event;
  this.getUsers();
  }

 
  deleteUser(userID:number){
    console.log(userID);
    this.loginService.deleteUser(userID).subscribe((res)=>{
      console.log(res);    
      this.ngOnInit()        
    })
  }

  
  logout(){
    localStorage.clear();
    this.router.navigate(["/login"])
  }


  addUser(): void {
    
    this.newUser.name=this.name
    this.newUser.email=this.email
    this.newUser.password=this.password
    this.newUser.userRole=this.userRole
    console.log(this.userRole);
    console.log(this.newUser);
    this.loginService.addUser(this.newUser).subscribe((user: User) => {
      this.users.push(user);
      console.log(user);
      this.newUser = new User();
      this.getUsers()
        },
        (error)=>{
          alert('Enter valid details');
        });
          
      }
  
  }




  

