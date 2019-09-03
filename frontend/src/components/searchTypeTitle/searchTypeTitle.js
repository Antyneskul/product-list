import React from 'react';
import styles from './searchTypeTitle.module.css';


const SearchTypeTitle = ({type}) => {
    const resultsTypes = {
        'ALL': 'All Results',
        'EXACT': '',
        'RELEVANT': 'Most Relevant Items',
        'MOST_POPULAR': 'Most Popular Items'
    };

    return (
        resultsTypes[type] ? <h2 className={styles.SearchTypeTitle}>{resultsTypes[type]}:</h2> : null
    )
};

export default SearchTypeTitle;
