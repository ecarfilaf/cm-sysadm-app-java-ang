import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class StorageService {
  // Save data
  setItem(key: string, value: any): void {
    localStorage.setItem(key, JSON.stringify(value));
  }

  // Retrieve data
  getItem(key: string): any {
    const data = localStorage.getItem(key);
    return data ? JSON.parse(data) : null;
  }

  // Remove specific item
  removeItem(key: string): void {
    localStorage.removeItem(key);
  }

  // Clear all data
  clear(): void {
    localStorage.clear();
  }
}