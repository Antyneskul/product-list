import React from 'react';
import styles from './pagination.module.css';

const Pagination = ({page, isVisible, onPageChange}) => {
    const onPageChangeHandler = () => {
        onPageChange(page + 1);
    };

    return isVisible && <div className={styles.pagination}>
        <button className={'btn btn-primary'} onClick={onPageChangeHandler}>Load More</button>
    </div>;
};

export default Pagination;
