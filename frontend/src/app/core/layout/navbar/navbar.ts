import { Component} from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatBadgeModule } from '@angular/material/badge';
import { StorageService } from '../../../services/core/storage';
import { ThemeService } from '../../../services/core/theme-service';
import { MatMenuModule } from '@angular/material/menu';

@Component({
  selector: 'app-navbar',
  imports: [
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatBadgeModule,
    MatMenuModule,
  ],
  templateUrl: './navbar.html',
  styleUrl: './navbar.scss',
})
export class Navbar {

  usrTheme: string = ' ';

  // // Inyectar el servicio en el constructor
  // constructor(private storage: StorageService) {}

  // ngOnInit() {
  //   // Usar el método del servicio
  //   this.usrTheme = this.storage.getItem('user-theme') || 'dark'; // Valor por defecto 'dark' si no hay nada guardado
  // }

  // onSave() {
  //   console.log(this.usrTheme);
  //   this.storage.setItem('user-theme', this.usrTheme);
  // } 

  constructor(public themeService: ThemeService) {}

  onThemeToggle() {
    this.themeService.toggleTheme();
  }

  isLoggedIn: boolean = false;

  login(){
    console.log('Login');
  }
  logout(){
    console.log('Logout');
  }
}
