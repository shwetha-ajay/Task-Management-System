import { TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';

import { TmsServiceService } from './tms-service.service';

describe('TmsServiceService', () => {
  let service: TmsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        
        HttpClientModule,
      ],
    });
    service = TestBed.inject(TmsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});




