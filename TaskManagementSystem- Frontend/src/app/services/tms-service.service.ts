import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/login';
import { Task } from '../class/task';
import { Observable } from 'rxjs';
import { User } from '../class/user';

@Injectable({
  providedIn: 'root'
})
export class TmsServiceService {

  email!:string;
  roleName!:string;
  static getTasks: any;
  

  getEmail(){
    return this.email
  }
  setEmail(email:string){
    this.email=email;
  }
  setRole(roleName:string){
    this.roleName=roleName;
  }
  getRole(){
    return this.roleName
  }

 url="http://localhost:8080/login"
 add="http://localhost:8080/user"
 apiUrl="http://localhost:8080/task"
 api="http://localhost:8080/viewTask"
 api2="http://localhost:8080/addUsers"
 api3="http://localhost:8080/viewAdmin"
 deletetask="http://localhost:8080/deleteTask"
 userTaskDetails="http://localhost:8080/searchByuser"
 getIds="http://localhost:8080/ids"


  constructor(private http:HttpClient) {}
  public sort(taskID:number){
    return this.http.get<number>(`http://localhost:8080/priorityscore/${taskID}`)
  }
 
    public login(data:any){
      return this.http.post(this.url,data)
    }

    public getuserId(email:String){
      return this.http.get(`http://localhost:8080/userid?email=${email}`)
    }

    public userTasks(userID:String){
      return this.http.get(`http://localhost:8080/searchByuser/${userID}`)
    }

    public addAdmin(user:Login){
      return this.http.post(this.url,user)
    }

    public getUserIds(): Observable<number[]> {
      return this.http.get<number[]>(`${this.getIds}`);
    }

    public addTask(task: Task): Observable<Task> {
      return this.http.post<Task>(`${this.apiUrl}`, task);
    }

    public getTasks(): Observable<any> {
      return this.http.get<any>(`${this.api}`);
    }

    public addUser(user: User): Observable<User> {
      return this.http.post<User>(`${this.api2}`, user);
    }

    public getUsers(): Observable<any[]> {
      return this.http.get<any[]>(`${this.api3}`);
    }

    public deleteTask(taskId:number) {
      console.log(taskId);
      return this.http.delete(`http://localhost:8080/deleteTask/${taskId}`);
    }

    public deleteUser(userId:number): Observable<any> {
      console.log(userId);
      return this.http.delete(`http://localhost:8080/deleteAdmin/${userId}`);
    }

    public updateStatus(taskId:number,status:string): Observable<any> {
    //  console.log(taskId);
    //  console.log(status);
      const statusUpdate={
        taskId:taskId,
        status:status
        }
        console.log(statusUpdate);
        return this.http.post("http://localhost:8080/updatestatus",statusUpdate);
      }
    
  }

