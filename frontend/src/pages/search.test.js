import { shallow } from 'enzyme';
import React from 'react';
import Search from './search';

describe('Search', () => {
    const getData = jest.fn();
    let wrapper;
    getData.mockReturnValue({data: [], total: 0, type: 'EXACT'});

    beforeEach(() => {
        wrapper = shallow(<Search/>);
    });

    it('Search renders without crashing', () => {
        expect(wrapper).toBeDefined();
    });

    it('should render Search input', () => {
        expect(wrapper.find('SearchInput').length).toBe(1);
    });

    it('should render searchTypeTitle', () => {
        expect(wrapper.find('SearchTypeTitle').length).toBe(1);
    });

    it('should  render searchResults', () => {
        expect(wrapper.find('SearchResults').length).toBe(1);
    });

    it('should render pagination', () => {
        expect(wrapper.find('Pagination').length).toBe(1);
    })
});


