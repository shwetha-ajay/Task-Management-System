import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin.component';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { of } from 'rxjs';
import { Taskscores } from '../class/taskscores';
import { TmsServiceService } from '../services/tms-service.service';
import { Task } from '../class/task';
import { AddTaskComponent } from '../add-task/add-task.component';

describe('AdminComponent', () => {
  let component: AdminComponent;
  let fixture: ComponentFixture<AdminComponent>;
  let service: TmsServiceService;
  let httpMock: HttpTestingController;
   
  beforeEach(() => {
  
      TestBed.configureTestingModule({
        providers: [TmsServiceService],
        declarations: [AdminComponent],
        imports: [
          HttpClientTestingModule 
        ]
      });
  
      service = TestBed.inject(TmsServiceService); 
      httpMock = TestBed.inject(HttpTestingController);
  
    });

  it('should be created', () => {
      
      expect(service).toBeTruthy();
 });



  it('should return a user result', () => {

    service.getUserIds().subscribe(result => {

      expect(result).toBeTruthy();
    
    });
});


  it('should fetch user IDs successfully', () => {

   service.getUserIds(); // This should call the mocked service method
   let user:any;
   service.getUserIds().subscribe(result => {
     user=result;
     expect(user).toContain(4000);
  // const array = [4001, 4002, 4003]; // Check if the array contains the value 4001 
  // expect(array).toContain(4001); // Check if the array contains the value 4002 
  // expect(array).toContain(7010);
    });   
  });


  it('#getObservableValue should return value from observable', 

       (done: DoneFn) => { 

                  service.getUserIds().subscribe(value => { 
                          console.log(value);
                         expect(value).toContain(4001); 

                          done(); 
}); 


});

it('#getObservableValue should return value from observable', (done: DoneFn) => {
  const dummyUserIds = [4000, 4001, 4002];
  service.getUserIds().subscribe((value) => {
    expect(value).toEqual(dummyUserIds);
    done();
  });
  


});

it('should fetch user IDs successfully', fakeAsync(() => {
  const expectedUserIds = [4001, 4002, 4003];
  let actualUserIds: number[];

  // Mock the service to return an observable with the expected user IDs
  spyOn(service, 'getUserIds').and.returnValue(of(expectedUserIds));

  // Call the method that fetches user IDs
  component.fetchUserIds();

  // Use tick to simulate the passage of time and allow the observable to emit its value
  tick();

  // Get the actual user IDs from the component's property
  actualUserIds = component.userIds;

  // Make assertions
  expect(actualUserIds).toEqual(expectedUserIds);
}))
});
