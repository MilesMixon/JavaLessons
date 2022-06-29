import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerDetailsNavComponent } from './owner-details-nav.component';

describe('OwnerDetailsNavComponent', () => {
  let component: OwnerDetailsNavComponent;
  let fixture: ComponentFixture<OwnerDetailsNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerDetailsNavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwnerDetailsNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
