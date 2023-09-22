import { ComponentFixture, TestBed, fakeAsync, tick, waitForAsync } from "@angular/core/testing"
import { NgxPaginationModule } from 'ngx-pagination';
import { TmsServiceService } from '../services/tms-service.service';
import { HttpClientTestingModule } from "@angular/common/http/testing"
import { HttpClient, HttpResponse } from "@angular/common/http"
import { HttpTestingController } from "@angular/common/http/testing"
import { of } from "rxjs"
import { AdminDashboardComponent } from "./admin-dashboard.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

describe('User Service ',() => {

  let usersService:TmsServiceService
  let http:HttpClient;
  let httpController: HttpTestingController

  beforeEach(()=>{

    TestBed.configureTestingModule(
      {providers:[TmsServiceService],
      imports:[HttpClientTestingModule],
      })

      usersService = TestBed.inject(TmsServiceService);
      http = TestBed.inject(HttpClient);
      httpController = TestBed.inject(HttpTestingController)
  })


  it('service created',()=>{
    expect(usersService).toBeDefined()
  })


  it('getUser',() =>{

    const testData = [
      {
        email: 'jina@gmail.com',
        name: 'Jina S',
        password: 'password123',
      },

      {
        email: 'soya@gmail.com',
        name: 'Soya Smith',
        password: 'securepass',
      }
    ];

    const testData1 = [  
      {
        email: 'jina@gmail.com',
        name: 'Jina S',
        password: 'password123',
      },

      {
        email: 'soya@gmail.com',
        name: 'Soya Smith',
        password: 'securepass',
      }
    ];

    usersService.getUsers().subscribe((users)=>{

      console.log(users);
      expect(users).toEqual(testData)
    })


    const req = httpController.expectOne('http://localhost:8080/viewAdmin');
    req.flush(testData1)
    expect(req.request.method).toBe('GET');

  })

});


const testData = [
  {
    userID:'401',
    email: 'john@example.com',
    name: 'John Doe',
    password: 'password123',
  },

  {
    userID:404,
    email: 'jane@example.com',
    name: 'Jane Smith',
    password: 'securepass',
  },

  {
    userID:405,
    email: 'bob@example.com',
    name: 'Bob Johnson',
    password: 'mypassword',
  },
];

class UserServiceStub {
  getUsers() {
    return of(testData);
  }

}




describe('AppComponent', () => {

  let fixture: ComponentFixture<AdminDashboardComponent>;

  let component: AdminDashboardComponent;

  let mockUsersService: MockUsersService;

  class MockUsersService {

    getUsers() {

      // Replace this with your mock user data

      const mockUsers = [

        { userID: '1', name: 'User 1' ,email:'user1@example.com',password:'password1'},

        { userID: '2', name: 'User 2',email:'user2@example.com',password:'pass1455' },

      ];
      return of(mockUsers);
    }

  }




  beforeEach(async () => {

    mockUsersService = new MockUsersService();

    await TestBed.configureTestingModule({

      declarations: [AdminDashboardComponent],

      providers: [{ provide: TmsServiceService, useValue: mockUsersService }],
      imports: [ HttpClientTestingModule,
                 NgxPaginationModule,FormsModule,
                 ReactiveFormsModule ],

    }).compileComponents();

  });


  beforeEach(() => {

    fixture = TestBed.createComponent(AdminDashboardComponent);

    component = fixture.componentInstance;

    // You may need to set up any test data here (e.g., mock users)

  });



  it('should fetch and render users ', fakeAsync(() => {

    // Create a spy for the getUsers method

    spyOn(mockUsersService, 'getUsers').and.callThrough();

    fixture.detectChanges();

    // Simulate asynchronous data retrieval

    tick();

  
    // Check if getUsers method was called

    expect(mockUsersService.getUsers).toHaveBeenCalled();

    // Check if user data is rendered in the table 
    const tableRows = fixture.nativeElement.querySelectorAll('tbody tr'); 
    expect(tableRows.length).toBe(2); // Assuming 2 mock users in the test data
    const firstRowCells = tableRows[0].querySelectorAll('td');
    expect(firstRowCells[0].textContent).toContain('1'); // Assuming the first user has userID 1
    expect(firstRowCells[1].textContent).toContain('User 1');
    expect(firstRowCells[2].textContent).toContain('user1@example.com');
    expect(firstRowCells[3].textContent).toContain('password1');

  }));
});



// test case for deleteuser
describe('delete', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminDashboardComponent],
      providers: [TmsServiceService],
      imports:[HttpClientTestingModule,NgxPaginationModule,FormsModule,
        ReactiveFormsModule ]
    }).compileComponents();
  });

  let fixture: ComponentFixture<AdminDashboardComponent>; 
  let component: AdminDashboardComponent;  
  let service: TmsServiceService; 

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDashboardComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(TmsServiceService);
  });

 
  
  it('should call getUsers after successful deletion and remove the user from users', fakeAsync(() => {
      const userIDToDelete = 1;
  
      // Create a mock list of users
      component.users = [
        { id: 1, name: 'User 1' },
        { id: 2, name: 'User 2' },
        { id: 3, name: 'User 3' },
      ];
  
   
      // Create a spy for the deleteUser method of the loginService
      spyOn(service, 'deleteUser').and.returnValue(of({ success: true }));
  
 
      // Create a spy for the getUsers method of the component
      spyOn(component, 'getUsers').and.callThrough();
  
    
      // Call the delete method with the mock userID
      component.deleteUser(userIDToDelete);
  
    
      // Expect deleteUser method to be called with the correct userID
      expect(service.deleteUser).toHaveBeenCalledWith(userIDToDelete);
  
    
      // Simulate successful deletion
      const deleteUserSubscription = service.deleteUser(userIDToDelete);
      deleteUserSubscription.subscribe(() => {
        // Expect getUsers method to be called after successful deletion
        expect(component.getUsers).toHaveBeenCalled();
  
   
        // Trigger change detection to handle the asynchronous operations
        tick();
  
   
        component.users = component.users.filter((user: { id: number; }) => user.id !== userIDToDelete); 
    
      });
    }));
  });
    




  

