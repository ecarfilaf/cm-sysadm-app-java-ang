import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { DashboardComponent } from "./core/layout/dashboard/dashboard.component";
import { NavigationComponent } from "./core/layout/navigation/navigation.component";
import { StorageService } from './services/core/storage';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatSidenavModule, MatToolbarModule, NavigationComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App  implements OnInit {
  protected readonly title = signal('frontend');

  usrTheme = '';

  constructor(private storage: StorageService) {}

  ngOnInit() {
    // Load saved data on initialization
    const savedTheme = this.storage.getItem('userTheme');
    if (savedTheme) {
      console.log('Current Theme,', savedTheme);
      this.usrTheme = savedTheme;
    } else{
      console.log('No saved theme found, using default:', this.usrTheme);
      this.storage.setItem('userTheme', this.usrTheme);
    }
  }

  onSave() {
    this.storage.setItem('userTheme', this.usrTheme);
  }
  
}
