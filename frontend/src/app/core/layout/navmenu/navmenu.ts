import { Component, Input, signal } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RouterLink } from '@angular/router';
import {MatExpansionModule} from '@angular/material/expansion';

interface NavItem {
  label: string;
  icon: string;
  route?: string;
  badge?: string;
  children?: NavItem[];
}

@Component({
  selector: 'app-navmenu',
  imports: [
    MatListModule,
    MatIconModule,
    RouterLink,
    MatExpansionModule,
  ],
  templateUrl: './navmenu.html',
  styleUrl: './navmenu.scss',
})
export class Navmenu {
  @Input() navItems: NavItem[] = [];
 
  readonly panelOpenState = signal(false);
}
