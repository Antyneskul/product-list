import { shallow } from 'enzyme';
import React from 'react';
import App from './App';

it('App renders without crashing', () => {
  shallow(<App/>);
});
