import { shallow, mount } from 'enzyme';
import React from 'react';
import SearchInput from './searchInput';

describe('Search Input', () => {
    const onSearch = jest.fn();

    it('should render', () => {
        shallow(<SearchInput/>)
    });

    it('should pass input value to onSearch', () => {
        const wrapper = mount(<SearchInput onSearch={onSearch}/>);
        const input = wrapper.find('input');
        const button = wrapper.find('button');

        expect(input.length).toBe(1);
        expect(button.length).toBe(1);

        input.instance().value = 'Search';
        input.simulate('change');

        button.simulate('submit');

        expect(onSearch).toBeCalledWith('Search');

    });
});
