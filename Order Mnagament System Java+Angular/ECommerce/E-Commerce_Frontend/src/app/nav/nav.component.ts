import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserStorageService } from '../services/storage/user-storage.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {


  isUserLoggedIn: boolean = UserStorageService.isUserLoggedIn();
  isAdminLoggedIn: boolean = UserStorageService.isAdminLoggedIn();
  isVendorLoggedIn: boolean = UserStorageService.isVendorLoggedIn();

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.router.events.subscribe(event => {
      if (event.constructor.name === "NavigationEnd") {
        this.isUserLoggedIn = UserStorageService.isUserLoggedIn();
        this.isAdminLoggedIn = UserStorageService.isAdminLoggedIn();
        this.isVendorLoggedIn = UserStorageService.isVendorLoggedIn();
      }
    })
  }

  logout() {
    UserStorageService.signOut();
    this.router.navigateByUrl('login');
  }

}