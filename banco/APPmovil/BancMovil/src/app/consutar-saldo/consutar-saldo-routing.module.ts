import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ConsutarSaldoPage } from './consutar-saldo.page';

const routes: Routes = [
  {
    path: '',
    component: ConsutarSaldoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConsutarSaldoPageRoutingModule {}
