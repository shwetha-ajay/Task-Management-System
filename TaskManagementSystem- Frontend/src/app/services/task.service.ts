import { Injectable } from '@angular/core';
import { Task } from '../class/task';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks!: Task[] ;

  api="http://localhost:8080/viewTask"
  constructor(private http: HttpClient) {}
  
  getTasksByStatus(status: string): Task[] {
    return this.tasks.filter(task => task.status === status);
  }

  public getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.api}`);
  }

}
