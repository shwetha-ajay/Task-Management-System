import { TestBed } from '@angular/core/testing';
import { CanActivateFn,Router } from '@angular/router';
import { TmsServiceService } from '../services/tms-service.service';

import { AuthGuard } from './auth.guard';

describe('AuthGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      // TestBed.runInInjectionContext(() => new AuthGuard().canActivate(...guardParameters));
      TestBed.runInInjectionContext(() => new AuthGuard(mockLoginService, mockRouter).canActivate(...guardParameters));
      let mockLoginService: TmsServiceService;
      let mockRouter: Router;
    

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
