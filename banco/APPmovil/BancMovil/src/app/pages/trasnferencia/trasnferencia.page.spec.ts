import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { TrasnferenciaPage } from './trasnferencia.page';

describe('TrasnferenciaPage', () => {
  let component: TrasnferenciaPage;
  let fixture: ComponentFixture<TrasnferenciaPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrasnferenciaPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(TrasnferenciaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
