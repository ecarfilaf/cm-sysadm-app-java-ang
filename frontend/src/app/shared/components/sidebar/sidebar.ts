import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';

interface NavItem {
  label: string;
  icon: string;
  route?: string;
  badge?: string;
  children?: NavItem[];
}

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.html',
  imports: [
    MatIconModule,  RouterLink, 
  ],
  styleUrls: ['./sidebar.scss']
})
export class SidebarComponent {
  navItems: NavItem[] = [
    { label: 'Dashboards', icon: 'dashboard', route: '/dashboard', badge: '5' },
    { label: 'E-Commerce', icon: 'shopping_cart', children: [
        { label: 'Products', icon: 'production_quantity_limits', route: '/ecommerce/products' }
    ]},
    { label: 'Projects',   icon: 'folder' },
    { label: 'Chat',       icon: 'chat' },
    { label: 'File Manager', icon: 'folder_open', badge: 'New' },
    { label: 'Calendar',    icon: 'calendar_today' },
    { label: 'Email',       icon: 'email', badge: 'New' },
    { label: 'Tasks',       icon: 'check_circle' },
    { label: 'Pages',       icon: 'pages' },
    { label: 'Auth',        icon: 'lock', badge: 'Special' },
  ];
}