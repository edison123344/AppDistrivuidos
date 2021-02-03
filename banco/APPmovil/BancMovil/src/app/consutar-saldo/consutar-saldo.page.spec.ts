import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ConsutarSaldoPage } from './consutar-saldo.page';

describe('ConsutarSaldoPage', () => {
  let component: ConsutarSaldoPage;
  let fixture: ComponentFixture<ConsutarSaldoPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsutarSaldoPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ConsutarSaldoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
