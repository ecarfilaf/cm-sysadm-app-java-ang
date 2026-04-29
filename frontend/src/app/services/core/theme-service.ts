import { Injectable, signal, effect } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class ThemeService {
  // Initialize from localStorage or default to 'light-theme'
  theme = signal<string>(localStorage.getItem('user-theme') || 'light-theme');

  constructor() {
    // Automatically update localStorage and DOM when theme signal changes
    effect(() => {
      const currentTheme = this.theme();
      localStorage.setItem('user-theme', currentTheme);
      this.applyThemeToElement(currentTheme);
    });
  }

  toggleTheme() {
    this.theme.update(t => t === 'light-theme' ? 'dark-theme' : 'light-theme');
  }

  private applyThemeToElement(themeName: string) {
    const root = document.documentElement; // Or document.body
    root.classList.remove('light-theme', 'dark-theme');
    root.classList.add(themeName);
  }
}