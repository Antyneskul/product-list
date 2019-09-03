import React, { useEffect, useState, Fragment } from 'react';
import Pagination from '../components/pagination/pagiantion';
import SearchInput from '../components/searchInput/searchInput';
import SearchResults from '../components/searchResults/searchResults';
import SearchTypeTitle from '../components/searchTypeTitle/searchTypeTitle';

const Search = ({getData}) => {
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);
    const [data, setData] = useState([]);
    const [resultsType, setResultsType] = useState('MOST_POPULAR');
    const [searchQuery, setSearchQuery] = useState('');
    const [page, setPage] = useState(0);
    const [total, setTotal] = useState(0);
    const pageSize = 10;
    useEffect(() => {
        (async () => {
            try {
                setLoading(true);

                const {products, type, total} = await getData(searchQuery, page, pageSize);

                setResultsType(type);
                setTotal(total);
                setData(data => [...data, ...products]);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }

        })();
    }, [page, searchQuery, getData]);

    useEffect(() => {
        setData([]);
    }, [resultsType]);

    const renderBody = () => loading
        ? <h4>Loading...</h4>
        : <Fragment>
            <SearchTypeTitle type={resultsType}/>
            <SearchResults results={data}/>
            <Pagination
                page={page}
                isVisible={resultsType === 'EXACT' && data.length < total}
                onPageChange={setPage}/>
        </Fragment>;

    return (
        <div className="App">
            <SearchInput onSearch={setSearchQuery}/>
            {!error && renderBody()}
            {error && <h4 className={'error'}>{error}</h4>}
        </div>
    );
};

export default Search;
