import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-stat-card',
  imports: [CommonModule, MatIconModule],
  template: `
  <div class="stat-card">
    <div class="info">
      <p class="amount">{{prefix}}{{value | number}}</p>
      <p class="label">{{label}}</p>
      <span class="delta" [class.up]="delta > 0" [class.down]="delta < 0">
        {{delta > 0 ? '+' : ''}}{{delta}}% 
      </span> <b class="label">Since last week</b>
    </div>
    <div class="icon-wrap">
      <mat-icon>{{icon}}</mat-icon>
    </div>
  </div>
  `,
  styleUrls: ['./stat-card.scss']
})
export class StatCardComponent {
  @Input() value!: number;
  @Input() label!: string;
  @Input() delta!: number;
  @Input() icon = 'attach_money';
  @Input() prefix = '';
}