import { Component, inject } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { AsyncPipe } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { RouterLink } from '@angular/router';
import { Navbar } from '../navbar/navbar';
import { Navmenu } from '../navmenu/navmenu';

interface NavItem {
  label: string;
  icon: string;
  route?: string;
  badge?: string;
  children?: NavItem[];
}

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.scss',
  imports: [
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    AsyncPipe,
    DashboardComponent,
    RouterLink,
    Navbar,
    Navmenu,
  ],
})
export class NavigationComponent {
  private breakpointObserver = inject(BreakpointObserver);

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map((result) => result.matches),
    shareReplay(),
  );

  navItems: NavItem[] = [
    { label: 'Dashboards', icon: 'dashboard', route: '/dashboard', badge: '5' },
    { label: 'Admin', icon: 'lock', children: [
        { label: 'Users', icon: 'manage_accounts', route: '/admin/users' },
        { label: 'Roles', icon: 'settings_account_box', route: '/admin/roles' }
    ]},
    { label: 'Projects',   icon: 'folder', route: '/projects' },
    { label: 'Chat',       icon: 'chat' },
    { label: 'File Manager', icon: 'folder_open', badge: 'New' },
    { label: 'Calendar',    icon: 'calendar_today' },
    { label: 'Email',       icon: 'email', badge: 'New' },
    { label: 'Tasks',       icon: 'check_circle' },
    { label: 'Pages',       icon: 'pages' },
    { label: 'Auth',        icon: 'lock', badge: 'Special' },
  ];
}
