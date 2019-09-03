import { shallow } from 'enzyme';
import React from 'react';
import SearchTypeTitle from './searchTypeTitle.js';

describe('searchTypeTitle', () => {
    it('should render', () => {
        shallow(<SearchTypeTitle/>)
    });

    it('should render null without type property', () => {
        const wrapper = shallow(<SearchTypeTitle/>);
        expect(wrapper.type()).toBe(null);
    });

    it('should render correct text depends on type property', () => {
        const wrapper = shallow(<SearchTypeTitle type={'EXACT'}/>);
        expect(wrapper.type()).toBe(null);
    });

    it('should render correct text depends on type property', () => {
        const wrapper = shallow(<SearchTypeTitle type={'ALL'}/>);
        expect(wrapper.find('h2').text()).toBe('All Results:');
    });

    it('should render correct text depends on type property', () => {
        const wrapper = shallow(<SearchTypeTitle type={'RELEVANT'}/>);
        expect(wrapper.find('h2').text()).toBe('Most Relevant Items:');
    });

    it('should render correct text depends on type property', () => {
        const wrapper = shallow(<SearchTypeTitle type={'MOST_POPULAR'}/>);
        expect(wrapper.find('h2').text()).toBe('Most Popular Items:');
    });
});
