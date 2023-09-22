import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, NavigationExtras } from '@angular/router';
import { TmsServiceService } from '../services/tms-service.service';

 

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
 constructor(private loginService: TmsServiceService, private router: Router) {}
   
 
canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let roleName = localStorage.getItem('key');
    
    const expectedRole: any = route.data['expectedRole'];
    console.log(expectedRole);
    console.log(roleName);
  
    if (route.routeConfig?.path === 'Admin' && expectedRole.includes(roleName) && (roleName === 'superadmin' || roleName === 'Admin')) {
      // User is trying to access the 'Admin' route without the necessary roles
      // Redirect to the 'dashboard' route or display an error message
      return true;
    }

    if (roleName ==='Admin' && expectedRole === 'User') {
      // User is authenticated and has the expected role, allow access to user dashboard
      return true;    
    }

    if (route.routeConfig?.path === 'dashboard' && !expectedRole.includes(roleName) && roleName==="superadmin") {
      // User is trying to access the 'admin' route without the necessary roles
      // Redirect to the 'dashboard' route
      const navigationExtras: NavigationExtras = { replaceUrl: true };
      return true;
    }
  
    if (roleName ==='User' && expectedRole === 'User') {
      // User is authenticated and has the expected role, allow access to user dashboard
      return true;
    }
      
    if (roleName ==='Admin' && expectedRole === 'User') {
      // User is authenticated and has the expected role, allow access to user dashboard
      return true;  
    }
   
    if (roleName === 'superadmin' && expectedRole === 'superadmin') {
      return true;
    }   
     else { // User is not authenticated, redirect to login page 
      console.log("object");
      this.router.navigate(['/login']); 
      return false;
     }
    
  }
}

