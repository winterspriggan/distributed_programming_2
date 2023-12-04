import React, {useEffect, useState} from 'react';
import './CreateClaim.css'
import axios from "axios";
import swal from "sweetalert";
import TextInput from "../../../../common/TextInput/TextInput";
import Button from "../../../../common/Button/Button";
import SelectInput from "../../../../common/SelectInput/SelectInput";
import {ENDPOINT_GET_CONTRACTS, ENDPOINT_POST_CLAIM} from '../../../../common/Endpoint/Endpoint.js'

export default function CreateClaim({customer}) {

    const [contracts, setContracts] = useState(null);
    const [selectedContract, setSelectedContract] = useState(null);
    const [description, setDescription] = useState('');

    useEffect(() => {
        console.log(customer.id);
        axios.get(ENDPOINT_GET_CONTRACTS, {params: {id: customer.id}})
            .then(response => {
                setContracts(response.data);
            })
            .catch(e => {
                swal({
                    title: '시스템 오류', text: '잠시후 다시 시도해주세요. 불편을 드려 죄송합니다.', icon: 'error', button: '확인',
                });
            });
    }, []);


    const handleSubmit = async (e) => {
        e.preventDefault();
        const data = {
            contract_id: selectedContract,
            description: description
        }
        await axios.post(ENDPOINT_POST_CLAIM, data)
            .then(response => {
                swal({
                    title: '보상금 청구 완료',
                    text: '보상금 청구에 성공하였습니다.',
                    icon: 'success',
                    button: '확인',
                });
            })
            .catch(error => {
                swal({
                    title: '시스템 오류', text: '잠시후 다시 시도해주세요. 불편을 드려 죄송합니다.', icon: 'error', button: '확인',
                });
            });
    };

    if (contracts == null) return null;
    else
        return (
            <div className={'create_claim'}>
                <h2>보상금 청구</h2>
                <form onSubmit={handleSubmit}>
                    <SelectInput text={'계약아이디'} values={contracts.map(function (contract) {
                        return contract.id
                    })} onChange={(e) => setSelectedContract(e.target.value)}/>
                    <TextInput text={'내용'} value={description} onChange={(e) => setDescription(e.target.value)}/>
                    <Button text={'완료'} type="submit"/>
                </form>
            </div>
        );
}