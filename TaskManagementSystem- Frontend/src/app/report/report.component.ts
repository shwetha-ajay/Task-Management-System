import { Component, OnInit } from '@angular/core';
import { Task } from '../class/task';
import { TaskService } from '../services/task.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit{
  taskStatusCounts: { label: string; count: number; }[] | undefined;
  taskPriorityCounts: { label: string; count: number; }[] | undefined;
  // statusCounts: { label: string; count: number; }[] | undefined;
  constructor(private taskService: TaskService) { }

  ngOnInit(): void {}

  generateStatusReport(): void {
    this.taskService.getTasks().subscribe((tasks: Task[]) => {
      this.taskStatusCounts = this.countStatusOccurrences(tasks);
    });
  }

  countStatusOccurrences(tasks: Task[]): { label: string; count: number }[] {
    const statusCounts: { [status: string]: number } = {};
    tasks.forEach((task) => {
      const status = task.status;
      statusCounts[status] = statusCounts[status] ? statusCounts[status] + 1 : 1;
    });
    return Object.keys(statusCounts).map((status) => ({
      label: status,
      count: statusCounts[status],
    }));
  }


  generatePriorityReport():void{
    this.taskService.getTasks().subscribe((tasks: Task[]) => {
      this.taskPriorityCounts = this.countPriorityOccurrences(tasks);
    });
  }

  countPriorityOccurrences(tasks: Task[]): { label: string; count: number }[] {
    const priorityCounts: { [priority: string]: number } = {};
    tasks.forEach((task) => {
      const priority = task.priority;
      priorityCounts[priority] = priorityCounts[priority] ? priorityCounts[priority] + 1 : 1;
    });
    return Object.keys(priorityCounts).map((priority) => ({
      label: priority,
      count: priorityCounts[priority],
    }));
  }

}
