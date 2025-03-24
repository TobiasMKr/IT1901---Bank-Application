// jest.setup.js
global.IntersectionObserver = class {
  constructor(callback) {
    this.callback = callback;
    this.observables = [];
  }

  observe(element) {
    this.observables.push(element);
  }

  unobserve(element) {
    this.observables = this.observables.filter((obs) => obs !== element);
  }

  disconnect() {
    this.observables = [];
  }

  trigger(entries) {
    this.callback(entries);
  }
};
