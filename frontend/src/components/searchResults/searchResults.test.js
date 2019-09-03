import { shallow } from 'enzyme';
import React from 'react';
import SearchResults from './searchResults.js';

describe('SearchResults', () => {
    it('renders without crashing', () => {
        shallow(<SearchResults/>);
    });

    it('renders two SearchResult elements', () => {
        const results = [
            {
                id: 1,
                title: 'Garmin 1',
                price: '$500',
                rating: 4.2,
                imageUrl: ''
            },
            {
                id: 2,
                title: 'Garmin 2',
                price: '$500',
                rating: 4.2,
                imageUrl: ''
            }
        ];

        const wrapper = shallow(<SearchResults results={results}/>);

        expect(wrapper.find('SearchResult').length).toBe(2);
    });
});
