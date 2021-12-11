import { Component, OnInit } from '@angular/core';
import { Formateur } from './formateur';
import { FormateurService } from './formateur.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public formateurs: Formateur[];
  public editFormateur: Formateur;
  public deleteFormateur: Formateur;

  constructor(private formateurService: FormateurService){}

  ngOnInit() {
    this.getFormateurs();
  }

  public getFormateurs(): void {
    this.formateurService.getFormateurs().subscribe(
      (response: Formateur[]) => {
        this.formateurs = response;
        console.log(this.formateurs);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddFormateur(addForm: NgForm): void {
    document.getElementById('add-formateur-form').click();
    this.formateurService.addFormateur(addForm.value).subscribe(
      (response: Formateur) => {
        console.log(response);
        this.getFormateurs();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

 /* public onUpdateEmloyee(employee: Employee): void {
    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }*/

 /* public onDeleteEmloyee(employeeId: number): void {
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
*/
 /* public searchEmployees(key: string): void {
    console.log(key);
    const results: Employee[] = [];
    for (const employee of this.employees) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.employees = results;
    if (results.length === 0 || !key) {
      this.getEmployees();
    }
  }*/

  public onOpenModal(formateur: Formateur, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addFormateurModal');
    }
    if (mode === 'edit') {
      this.editFormateur = formateur;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      this.deleteFormateur = formateur;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }

    
    container.appendChild(button);
    button.click();
  }



}
