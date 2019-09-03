import { shallow, mount} from 'enzyme';
import React from 'react';
import Pagination from './pagiantion';

describe('Pagination', () => {
    const onPageChange = jest.fn();

    it('should render', () => {
        shallow(<Pagination/>);
    });

    it('should be visible', () => {
        const wrapper = shallow(<Pagination onPageChange={onPageChange} isVisible/>);

        expect(wrapper.find('button').exists()).toBe(true);
    });

    it('should be invisible', () => {
        const wrapper = shallow(<Pagination onPageChange={onPageChange} isVisible={false}/>);

        expect(wrapper.find('button').exists()).toBe(false);
    });

    it('should call onPageChange on button click', () => {
        const wrapper = mount(<Pagination onPageChange={onPageChange} page={1}isVisible/>);
        wrapper.find('button').simulate('click');

        expect(onPageChange.mock.calls.length).toBe(1);
        expect(onPageChange).toBeCalledWith(2);
    });
});
