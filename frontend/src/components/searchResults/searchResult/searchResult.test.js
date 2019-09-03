import { shallow } from 'enzyme';
import React from 'react';
import SearchResult from './searchResult.js';

describe('SearchResult', () => {
    const result = {
        id: 1,
        title: 'Garmin 1',
        price: '$500',
        rating: 4.2,
        imageUrl: ''
    };

    it('renders without crashes', () => {
        shallow(<SearchResult result={result}/>);
    });

    it('renders with all properties', () => {
        const wrapper = shallow(<SearchResult result={result}/>);

        expect(wrapper.find('h4').text()).toBe(result.title);
        expect(wrapper.find('img').prop('src')).toBe(result.imageUrl);
        expect(wrapper.find('.details').text()).toBe(`Price: ${result.price}Rating: ${result.rating}`);

    });
});
